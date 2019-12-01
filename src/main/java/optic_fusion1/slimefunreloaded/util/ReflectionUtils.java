package optic_fusion1.slimefunreloaded.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;

public final class ReflectionUtils {

  private static final Map<Class<?>, Class<?>> conversion = new HashMap<>();
  private static Method handle_player, handle_world, handle_entity, handle_animals, sendPacket;
  private static Field player_connection;

  static {
    conversion.put(Byte.class, Byte.TYPE);
    conversion.put(Short.class, Short.TYPE);
    conversion.put(Integer.class, Integer.TYPE);
    conversion.put(Long.class, Long.TYPE);
    conversion.put(Character.class, Character.TYPE);
    conversion.put(Float.class, Float.TYPE);
    conversion.put(Double.class, Double.TYPE);
    conversion.put(Boolean.class, Boolean.TYPE);

    try {
      handle_world = getClass(PackageName.OBC, "CraftWorld").getMethod("getHandle");
      handle_player = getClass(PackageName.OBC, "entity.CraftPlayer").getMethod("getHandle");
      handle_entity = getClass(PackageName.OBC, "entity.CraftEntity").getMethod("getHandle");
      handle_animals = getClass(PackageName.OBC, "entity.CraftAnimals").getMethod("getHandle");
      player_connection = getClass(PackageName.NMS, "EntityPlayer").getField("playerConnection");
      sendPacket = getMethod(getClass(PackageName.NMS, "PlayerConnection"), "sendPacket");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private ReflectionUtils() {
  }

  public static Object getHandle(CraftObject type, Object object) throws Exception {
    switch (type) {
      case PLAYER:
        return handle_player.invoke(object);
      case WORLD:
        return handle_world.invoke(object);
      case ENTITY:
        return handle_entity.invoke(object);
      case ANIMALS:
        return handle_animals.invoke(object);
      default:
        return null;
    }
  }

  public static Class<?> getClass(PackageName pkg, String name){
    return getClass(pkg.toPackage() + getVersion() + "." + name);
  }
  
  public static Class<?> getNMSClass(String name) {
    return getClass("net.minecraft.server." + getVersion() + "." + name);
  }

  public static Class<?> getCraftClass(String name) {
    return getClass("org.bukkit.craftbukkit." + getVersion() + "." + name);
  }

  public static String getVersion() {
    try {
      return Bukkit.getServer().getClass().getPackage().getName().substring(23);
    } catch (Exception e) {
    }
    return "Couldn't get the version used";
  }

  public static String getRawVersion() {
    try {
      String pkg = Bukkit.getServer().getClass().getPackage().getName();
      return pkg.substring(pkg.lastIndexOf('.') + 1);
    } catch (Exception e) {
    }
    return "Couldn't get the version used";
  }

  public static String getNMSVersion() {
    return "net.minecraft.server." + getRawVersion() + ".";
  }

  public static boolean isVersion(String... versions) {
    String nmsVersion = getVersion();
    for (String version : versions) {
      if (version.equals(nmsVersion)) {
        return true;
      }
    }
    return false;
  }

  public static Class<?> wrapperToPrimitive(Class<?> clazz) {
    if (clazz == Boolean.class) {
      return Boolean.TYPE;
    }
    if (clazz == Integer.class) {
      return Integer.TYPE;
    }
    if (clazz == Double.class) {
      return Double.TYPE;
    }
    if (clazz == Float.class) {
      return Float.TYPE;
    }
    if (clazz == Long.class) {
      return Long.TYPE;
    }
    if (clazz == Short.class) {
      return Short.TYPE;
    }
    if (clazz == Byte.class) {
      return Byte.TYPE;
    }
    if (clazz == Void.class) {
      return Void.TYPE;
    }
    if (clazz == Character.class) {
      return Character.TYPE;
    }
    return clazz;
  }

  public static Class<?>[] toParamTypes(Object... params) {
    Class<?>[] classes = new Class[params.length];
    for (int i = 0; i < params.length; ++i) {
      classes[i] = wrapperToPrimitive(params[i].getClass());
    }
    return classes;
  }

  @SuppressWarnings("unchecked")
  public static Enum<?> getEnum(String enumFullName) {
    String[] x = enumFullName.split("\\.(?=[^\\.]+$)");
    if (x.length == 2) {
      String enumClassName = x[0];
      String enumName = x[1];
      Class enumClass = getClass(enumClassName);
      if (enumClass.isEnum()) {
        return Enum.valueOf(enumClass, enumName);
      }
    }
    return null;
  }

  public static Class<?> getClass(String name) {
    try {
      return Class.forName(name);
    } catch (ClassNotFoundException e) {
      return null;
    }
  }

  public static void setValue(Object instance, String fieldName, Object value) {
    try {
      Field field = instance.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      field.set(instance, value);
    } catch (IllegalAccessException
     | IllegalArgumentException
     | NoSuchFieldException
     | SecurityException e) {
    }
  }

  @SuppressWarnings("deprecation")
  public static Object getValue(Object o, String fieldName) {
    try {
      Field field = o.getClass().getDeclaredField(fieldName);
      if (!field.isAccessible()) {
        field.setAccessible(true);
      }
      return field.get(o);
    } catch (IllegalAccessException
     | IllegalArgumentException
     | NoSuchFieldException
     | SecurityException e) {
      return null;
    }
  }

  public static Object callMethod(Object object, String method, Object... params) {
    try {
      Class<?> clazz = object.getClass();
      Method m = clazz.getDeclaredMethod(method, toParamTypes(params));
      m.setAccessible(true);
      return m.invoke(object, params);
    } catch (IllegalAccessException
     | IllegalArgumentException
     | NoSuchMethodException
     | SecurityException
     | InvocationTargetException e) {
      return null;
    }
  }

  @SuppressWarnings("deprecation")
  public static Method getMethod(Object o, String methodName, Class<?>... params) {
    try {
      Method method = o.getClass().getMethod(methodName, params);
      if (!method.isAccessible()) {
        method.setAccessible(true);
      }
      return method;
    } catch (NoSuchMethodException | SecurityException e) {
      return null;
    }
  }

  public static Field getField(Field field) {
    field.setAccessible(true);
    return field;
  }

  public static <T> Constructor<T> getConstructor(Class<T> c, Class<?>... paramTypes) {
    Class<?>[] t = toPrimitiveTypeArray(paramTypes);
    for (Constructor<?> constructor : c.getConstructors()) {
      Class<?>[] types = toPrimitiveTypeArray(constructor.getParameterTypes());

      if (equalsTypeArray(types, t)) {
        return (Constructor<T>) constructor;
      }
    }
    return null;
  }

  private static boolean equalsTypeArray(Class<?>[] a, Class<?>... o) {
    if (a.length != o.length) {
      return false;
    }
    for (int i = 0; i < a.length; i++) {
      if ((!a[i].equals(o[i])) && (!a[i].isAssignableFrom(o[i]))) {
        return false;
      }
    }
    return true;
  }

  public static Class<?>[] toPrimitiveTypeArray(Object... objects) {
    int a = objects != null ? objects.length : 0;
    Class<?>[] types = new Class[a];
    for (int i = 0; i < a; i++) {
      types[i] = conversion.containsKey(objects[i].getClass()) ? conversion.get(objects[i].getClass()) : objects[i].getClass();
    }
    return types;
  }
}
