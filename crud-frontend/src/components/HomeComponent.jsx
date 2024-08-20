import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getNumberOfUsers } from "../services/UserService";

const HomeComponent = () => {
    const navigator = useNavigate();
    const [numberOfUsers, setNumberOfUsers] = useState(0);
    function toDonate() {
        navigator("/donate")
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
        <div className="container">
            <h2 className="text-center">Welcome to the Bottle Drive!</h2>
            <div className="d-flex justify-content-center align-items-center" style={{ height: "33vh" }}>
                <div className="col-6 d-flex justify-content-center">
                    <button className="btn btn-primary btn-lg mb-2" type="button" onClick={toDonate}>
                        Donate Bottles
                    </button>
                </div>
                <div className="col-6 text-center">
                    <h3>Number of Bottles Delivered</h3>
                    <h1 style={{ fontSize: "5rem" }}>{numberOfUsers}</h1>
                </div>
            </div>
        </div>
    );
}

export default HomeComponent;