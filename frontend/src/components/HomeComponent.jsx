import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getNumberOfUsers } from "../services/UserService";
import "animate.css";

const HomeComponent = () => {
  const navigator = useNavigate();
  const [numberOfUsers, setNumberOfUsers] = useState(0);

  function toDonate() {
    navigator("/donate");
  }

  useEffect(() => {
    getCount();
  }, []);

  function getCount() {
    getNumberOfUsers()
      .then((response) => {
        setNumberOfUsers(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container bg-light p-5 rounded shadow-lg">
      <h2 className="text-center display-4 text-primary animate__animated animate__fadeIn">
        Welcome to the Bottle Drive!
      </h2>
      <div
        className="d-flex justify-content-center align-items-center"
        style={{ height: "33vh" }}
      >
        <div className="col-6 d-flex justify-content-center">
          <button
            className="btn btn-success btn-lg mb-2"
            type="button"
            onClick={toDonate}
            style={{
              transition: "transform 0.3s",
              backgroundColor: "#28a745",
              borderColor: "#28a745",
            }}
            onMouseOver={(e) =>
              (e.currentTarget.style.transform = "scale(1.1)")
            }
            onMouseOut={(e) => (e.currentTarget.style.transform = "scale(1)")}
          >
            Donate Bottles
          </button>
        </div>
        <div className="col-6 text-center">
          <div className="card shadow-sm">
            <div className="card-body">
              <h3 className="card-title">Number of Bottles Delivered</h3>
              <h1
                className="card-text animate__animated animate__bounce"
                style={{ fontSize: "5rem" }}
              >
                {numberOfUsers}
              </h1>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default HomeComponent;
