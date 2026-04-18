//#929
void main() {
    System.out.println(numUniqueEmails(new String[]{
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"}
    ));
}

public static int numUniqueEmails(String[] emails) {
    Set<String> newEmails = new HashSet<>();
    for (String email : emails) {
        //my solution
//            String[] subStr = email.split("@");
//            subStr[0] = subStr[0].replaceAll("\\.", "");
//            int index = subStr[0].indexOf("+");
//            if (index > 0) {
//                subStr[0] = subStr[0].substring(0, index);
//            }
//            newEmails.add(subStr[0] + "@" + subStr[1]);
        //best solution
        int atIndex = email.indexOf("@");
        int plusIndex = email.indexOf("+");
        String str1;
        if (plusIndex >= 0) str1 = email.substring(0, plusIndex);
        else str1 = email.substring(0, atIndex);
        str1 = str1.replaceAll("\\.", "") + email.substring(atIndex);
        newEmails.add(str1);
    }
    System.out.println(newEmails);
    return newEmails.size();
}
