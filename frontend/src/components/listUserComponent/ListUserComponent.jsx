import { useEffect, useState } from "react";
import { listUsers, deleteUser } from "../../services/UserService";
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

  function updateUser(id) {
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
                  onClick={() => updateUser(user.id)}
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
