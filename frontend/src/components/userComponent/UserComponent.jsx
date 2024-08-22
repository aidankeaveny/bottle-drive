import React from "react";
import { useEffect, useState } from "react";
import { createUser, getUser, updateUser } from "../../services/UserService";
import { useNavigate, useParams } from "react-router-dom";
import '../../App.css';


const UserComponent = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [numberOfBottles, setNumberOfBottles] = useState(0);
  const [address, setAddress] = useState("");
  const [isDelivered, setIsDelivered] = useState(false);

  const { id } = useParams();
  const [errors, setErrors] = useState({
    name: "",
    email: "",
    numberOfBottles: "",
    address: "",
    isDelivered: false,
  });

  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getUser(id)
        .then((response) => {
          setName(response.data.name);
          setEmail(response.data.email);
          setNumberOfBottles(response.data.numberOfBottles);
          setAddress(response.data.address);
          setIsDelivered(response.data.isDelivered);
        })
        .catch((error) => {
          // TODO: fix error
          console.error("Error while fetching user", error);
        });
    }
  }, [id]);

  function saveOrUpdateUser(e) {
    e.preventDefault();
    // TODO: Take out console statements
    if (validateForm()) {
      const user = { name, email, numberOfBottles, address, isDelivered };
      if (id) {
        updateUser(id, user)
          .then((response) => {
            console.log("User updated successfully", response.data);
            navigator("/");
          })
          .catch((error) => {
            console.error("Error while updating user", error);
          });
      } else {
        createUser(user)
          .then((response) => {
            console.log("User added successfully", response.data);
            navigator("/");
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
    if (name.trim()) {
      errorsCopy.firstName = "";
    } else {
      errorsCopy.firstName = "Name is required";
      valid = false;
    }
    if (email.trim()) {
      errorsCopy.email = "";
    } else {
      errorsCopy.email = "Email is required";
      valid = false;
    }
    if (numberOfBottles.trim()) {
      errorsCopy.numberOfBottles = "";
    } else {
      errorsCopy.numberOfBottles = "Number of Bottles is required";
      valid = false;
    }
    if (address.trim()) {
      errorsCopy.address = "";
    } else {
      errorsCopy.address = "Address is required";
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
              <label className="form-label">Name</label>
              <input
                type="text"
                placeholder="Enter User First Name"
                name="name"
                value={name}
                className={`form-control ${errors.name ? "is-invalid" : ""}`}
                onChange={(e) => setName(e.target.value)}
              />
              {errors.name && (
                <div className="invalid-feedback"> {errors.name} </div>
              )}
            </div>
            <div className="form-group mb-2">
              <label className="form-label">Email</label>
              <input
                type="text"
                placeholder="Enter User Email"
                name="email"
                value={email}
                className={`form-control ${errors.email ? "is-invalid" : ""}`}
                onChange={(e) => setEmail(e.target.value)}
              />
              {errors.email && (
                <div className="invalid-feedback"> {errors.email} </div>
              )}
              <div>
                <div className="form-group mb-2">
                  <label className="form-label">Number of Bottles</label>
                  <input
                    type="number"
                    placeholder="Enter Number of Bottles"
                    name="numberOfBottles"
                    value={numberOfBottles}
                    className={`form-control ${
                      errors.lastName ? "is-invalid" : ""
                    }`}
                    onChange={(e) => setNumberOfBottles(e.target.value)}
                  />
                  {errors.lastName && (
                    <div className="invalid-feedback">
                      {" "}
                      {errors.numberOfBottles}{" "}
                    </div>
                  )}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Address</label>
                  <input
                    type="text"
                    placeholder="Enter Address"
                    name="address"
                    value={address}
                    className={`form-control ${
                      errors.name ? "is-invalid" : ""
                    }`}
                    onChange={(e) => setAddress(e.target.value)}
                  />
                  {errors.name && (
                    <div className="invalid-feedback"> {errors.address} </div>
                  )}
                </div>
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
