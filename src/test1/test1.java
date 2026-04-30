void main() {
    System.out.println("test string");
    String str = "key1";
    Map<String,String> map1 = new HashMap<>();

    map1.put(str, "value1");
    System.out.println("map1 value for key = "+str+": "+map1.get(str));
    str = "key2";
    map1.put(str, "value2");
    str = new String("key1");
    System.out.println("all map1:");
    map1.entrySet().forEach(e -> System.out.println(e));
    System.out.println("map1 value for key = "+str+": "+map1.get(str));
}
