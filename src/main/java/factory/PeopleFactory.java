package factory;

import com.example.demo.entity.Director;
import com.example.demo.entity.Employee;

public class PeopleFactory {
  public static People createPeople(PeopleType peopleType) {
    switch (peopleType) {
      case Director:
        return new Director();
      case Employee:
        return new Employee();
      default:
        return null;
    }
  }
}
