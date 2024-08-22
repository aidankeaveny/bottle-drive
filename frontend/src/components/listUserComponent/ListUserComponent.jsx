import React from "react";
import { useEffect, useState } from "react";
import { listUsers, deleteUser, updateUser } from "../../services/UserService";
import { useNavigate } from "react-router-dom";

const ListUserComponent = () => {
  const [users, setUsers] = useState([]);

  const navigator = useNavigate();

  useEffect(() => {
    getAllUsers();
  }, []);

  function getAllUsers() {
    listUsers()
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function addNewUser() {
    navigator("/add-user");
  }

  function goToUpdateUser(id) {
    navigator(`/edit-user/${id}`);
  }

  function removeUser(id) {
    console.log(`User with id ${id} will be deleted`);
    deleteUser(id)
      .then((response) => {
        console.log("User deleted successfully", response.data);
        getAllUsers();
      })
      .catch((error) => {
        console.error("Error while deleting user", error);
      });
  }

  function toggleDeliveredStatus(id) {
    const updatedUsers = users.map((user) => {
      if (user.id === id) {
        return {
          ...user,
          isDelivered: !user.isDelivered
        };
      }
      return user;
    });

    const changedUser = updatedUsers.find((user) => user.id === id);
    if (!changedUser) {
      console.error("User not found");
      return;
    }

    setUsers(updatedUsers);
    updateUser(id, changedUser)
      .then((response) => {
        console.log("User updated successfully", response.data);
      })
      .catch((error) => {
        console.error("Error while updating user", error);
      });
  }

  return (
    <div className="container">
      <h2 className="text-center">User List</h2>
      <button className="btn btn-primary mb-2" type="button" onClick={addNewUser}>
        Add User
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>User Id</th>
            <th>User Name</th>
            <th>User Email</th>
            <th>Number of Bottles</th>
            <th>Address</th>
            <th>Deliver(ed)</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.numberOfBottles}</td>
              <td>{user.address}</td>
              <td>
                <button
                  className="btn btn-info"
                  type="button"
                  onClick={() => toggleDeliveredStatus(user.id)}
                >
                  {user.isDelivered ? "Unmark as Delivered" : "Mark as Delivered"}
                </button>
              </td>
              <td>
                <button
                  className="btn btn-info"
                  type="button"
                  onClick={() => goToUpdateUser(user.id)}
                >
                  Update
                </button>
                <button
                  className="btn btn-danger"
                  type="button"
                  onClick={() => removeUser(user.id)}
                  style={{ marginLeft: "10px" }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
          <tr></tr>
        </tbody>
      </table>
    </div>
  );
};

export default ListUserComponent;
