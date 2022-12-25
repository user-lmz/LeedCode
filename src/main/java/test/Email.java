package test;

import java.util.HashSet;

public class Email {
    public String address;
    public Email(String address) {
        this.address = address;
    }
    public int hashCode() {
        return address.hashCode();
    }

    public static void main(String[] args) {
        HashSet<Email> set = new HashSet<>();
        Email email = new Email("huawei.com");
        set.add(email);
        email.address = "silong.com";
        System.out.println(set.contains(email));
    }
}
