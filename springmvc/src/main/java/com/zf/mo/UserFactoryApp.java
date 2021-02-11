package com.zf.mo;

public class UserFactoryApp {

    public static void main(String[] args) {

        UserFactory userFactory = new UserFactory() {
            @Override
            public User createUser(String firstName, String lastName) {
                return new User(firstName,lastName);
            }
        };

        User user = userFactory.createUser("hello", "world");
        System.out.println(user);


        UserFactory userFactory2 = (firstName,lastName) -> new User(firstName,lastName);
        User user1 = userFactory2.createUser("hello", "world");
        System.out.println(user1);



        UserFactory userFactory3 = User::new;
        User user3 = userFactory3.createUser("hello", "world");
        System.out.println(user3);

    }




}
