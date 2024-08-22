import React from "react";
import { useNavigate } from "react-router-dom";
import { Navbar, Nav, Container, Button } from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import '../../App.css';

const HeaderComponent = () => {
  const navigate = useNavigate();

  function toSignIn() {
    navigate("/sign-in");
  }

  return (
    <header className="header">
      <Navbar className="navbar-custom" expand="lg">
        <Container>
          <Navbar.Brand href="/">Bottle Drive</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="/about">About</Nav.Link>
              <Nav.Link href="/contact">Contact</Nav.Link>
            </Nav>
            <Button variant="custom" onClick={toSignIn}>
              Sign In
            </Button>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </header>
  );
};

export default HeaderComponent;
