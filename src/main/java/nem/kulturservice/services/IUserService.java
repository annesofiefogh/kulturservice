package nem.kulturservice.services;

import nem.kulturservice.models.User;

import java.util.List;

public interface IUserService extends CrudService <User, Long> {
    List<User> findUserByName(String name);
}
