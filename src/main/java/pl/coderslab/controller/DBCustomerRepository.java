package pl.coderslab.controller;

import pl.coderslab.model.ConnectionManager;
import pl.coderslab.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
public class DBCustomerRepository implements CustomerRepository {
    private String host;
    private String user;
    private String password;
    private String database;

    @Override
    public void addCustomer(Customer customer) {
        PreparedStatement prepStatement = null;
        try (Connection connection = ConnectionManager.getConnection(this.host, this.user, this.password, this.database)) {
            prepStatement = connection.prepareStatement("insert into customerlogin values (?,?,?)");
            prepStatement.setLong(1, customer.getId());
            prepStatement.setString(2, customer.getFirstName());
            prepStatement.setString(3, customer.getLastName());
            prepStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e1) {
            System.out.println("Trying to override parameters: id");
            try (Connection connection = ConnectionManager.getConnection(this.host, this.user, this.password, this.database)) {
                prepStatement = connection.prepareStatement("insert into customerlogin(firstname,lastname) values (?,?)");
                prepStatement.setString(1, customer.getFirstName());
                prepStatement.setString(2, customer.getLastName());
                prepStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Overriding parameters: id - failed");
                e.printStackTrace();
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            System.out.println("Unexpected exception occured");
            e3.printStackTrace();
        }
    }

    @Override
    public void removeCustomer(Customer customer) {
        PreparedStatement prepStatement = null;
        try (Connection connection = ConnectionManager.getConnection(this.host, this.user, this.password, this.database)) {
            prepStatement = connection.prepareStatement("delete from customerlogin where id = (select subid from(select id as subid from customerlogin where firstname=? and lastname=? order by id limit 1) as subresult)");
            prepStatement.setString(1, customer.getFirstName());
            prepStatement.setString(2, customer.getLastName());
            prepStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e2) {
            System.out.println("Unexpected exception occured");
            e2.printStackTrace();
        }
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> list = new ArrayList<>();
        PreparedStatement prepStatement = null;
        try (Connection connection = ConnectionManager.getConnection(this.host, this.user, this.password, this.database)) {
            prepStatement = connection.prepareStatement("select * from customerlogin where id >?");
            prepStatement.setInt(1, 0);
            ResultSet resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);

                list.add(new Customer(id, firstname, lastname));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e2) {
            System.out.println("Unexpected exception occured");
            e2.printStackTrace();
        }

        return list;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
