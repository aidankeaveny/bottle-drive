import { useEffect, useState } from "react";
import {
  createUser,
  getUser,
  updateUser,
} from "../services/UserService";
import { useNavigate, useParams } from "react-router-dom";

const UserComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const { id } = useParams();
  const [errors, setErrors] = useState({
    firstName: "",
    lastName: "",
    email: "",
  });

  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getUser(id)
        .then((response) => {
          setFirstName(response.data.firstName);
          setLastName(response.data.lastName);
          setEmail(response.data.email);
        })
        .catch((error) => {
          console.error("Error while fetching user", error);
        });
    }
  }, [id]);

  function saveOrUpdateUser(e) {
    e.preventDefault();

    if (validateForm()) {
      const user = { firstName, lastName, email };
      console.log(user);
      if (id) {
        updateUser(id, user).then((response) => {
            console.log("User updated successfully",response.data);
            navigator('/users');
        }).catch((error) => {
            console.error("Error while updating user", error);
        });
      } else {
        createUser(user)
        .then((response) => {
          console.log("User added successfully", response.data);
          navigator("/users");
        })
        .catch((error) => {
          console.error("Error while adding user", error);
        });
      }
    }
  }
  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };
    if (firstName.trim()) {
      errorsCopy.firstName = "";
    } else {
      errorsCopy.firstName = "First Name is required";
      valid = false;
    }
    if (lastName.trim()) {
      errorsCopy.lastName = "";
    } else {
      errorsCopy.lastName = "Last Name is required";
      valid = false;
    }
    if (email.trim()) {
      errorsCopy.email = "";
    } else {
      errorsCopy.email = "Email is required";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }

  function pageTitle() {
    if (id) {
      return <h2 className="text-center">Update User</h2>;
    } else {
      return <h2 className="text-center">Add User</h2>;
    }
  }

  return (
    <div className="container">
      <br /> <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {pageTitle()}
          <form>
            <div className="form-group mb-2">
              <label className="form-label">User First Name</label>
              <input
                type="text"
                placeholder="Enter User First Name"
                name="firstName"
                value={firstName}
                className={`form-control ${
                  errors.firstName ? "is-invalid" : ""
                }`}
                onChange={(e) => setFirstName(e.target.value)}
              />
              {errors.firstName && (
                <div className="invalid-feedback"> {errors.firstName} </div>
              )}
            </div>
            <div className="form-group mb-2">
              <label className="form-label">User Last Name</label>
              <input
                type="text"
                placeholder="Enter User Last Name"
                name="lastName"
                value={lastName}
                className={`form-control ${
                  errors.lastName ? "is-invalid" : ""
                }`}
                onChange={(e) => setLastName(e.target.value)}
              />
              {errors.lastName && (
                <div className="invalid-feedback"> {errors.lastName} </div>
              )}
            </div>
            <div className="form-group mb-2">
              <label className="form-label">User Email</label>
              <input
                type="text"
                placeholder="Enter User Email"
                name="firstName"
                value={email}
                className={`form-control ${errors.email ? "is-invalid" : ""}`}
                onChange={(e) => setEmail(e.target.value)}
              />
              {errors.email && (
                <div className="invalid-feedback"> {errors.email} </div>
              )}
              <div>
                <button
                  className="btn btn-success"
                  onClick={saveOrUpdateUser}
                  type="button"
                >
                  Submit
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default UserComponent;
