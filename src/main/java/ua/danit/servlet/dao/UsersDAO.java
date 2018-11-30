package ua.danit.servlet.dao;

import ua.danit.servlet.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private List<User> users = new ArrayList<>();

    public UsersDAO() {
        users.add(new User("Katya", "https://www.bestfunnies.com/wp-content/uploads/2015/05/TOP-50-Beautiful-Girls-Girl-13-of-50.jpg"));
        users.add(new User("Alisa", "https://media.wmagazine.com/photos/5ad6028ecd127554706e0bf6/4:3/w_1536/victoria-beckham-designs-red-nose-day-spice-girls-tshirt-lead.jpg"));
        users.add(new User("Anya", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRwIY0_N7spRFLjFj-CfCHc6ao0lphMX6vo9UR0ctZdUcAra_7"));

    }

    public User getUserByIndex(int index) {
        return users.get(index % users.size());
    }
}
