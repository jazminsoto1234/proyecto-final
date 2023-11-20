import { useState, useEffect } from "react";
import { Navbar, Nav, Container } from "react-bootstrap";
import logo from '../assets/images/logo.svg';
import navIcon1 from '../assets/images/nav-icon1.svg';
import navIcon2 from '../assets/images/nav-icon2.svg';
import navIcon3 from '../assets/images/nav-icon3.svg';
import { HashLink } from 'react-router-hash-link';
import {
  BrowserRouter as Router
} from "react-router-dom";
export const NavBar = () => {

  const [activeLink, setActiveLink] = useState('Inicio');
  const [scrolled, setScrolled] = useState(false);

  useEffect(() => {
    const onScroll = () => {
      if (window.scrollY > 50) {
        setScrolled(true);
      } else {
        setScrolled(false);
      }
    }

    window.addEventListener("scroll", onScroll);

    return () => window.removeEventListener("scroll", onScroll);
  }, [])

  const onUpdateActiveLink = (value) => {
    setActiveLink(value);
  }

  return (
      <Navbar expand="md" className={scrolled ? "scrolled" : ""}>
        <Container>
          <Navbar.Brand href="/">
            <img src={logo} alt="Logo" />
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav">
            <span className="navbar-toggler-icon"></span>
          </Navbar.Toggle>
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ms-auto">
              <Nav.Link href="/" className={activeLink === 'Inicio' ? 'active navbar-link' : 'navbar-link'} onClick={() => onUpdateActiveLink('Inicio')}>Inicio</Nav.Link>
              <Nav.Link href="#Tienda" className={activeLink === 'Tienda' ? 'active navbar-link' : 'navbar-link'} onClick={() => onUpdateActiveLink('Tienda')}>Tienda</Nav.Link>
              <Nav.Link href="/Cart" className={activeLink === 'Mi Carrito' ? 'active navbar-link' : 'navbar-link'} onClick={() => onUpdateActiveLink('Mi Carrito')}>Mi Carrito</Nav.Link>
              <Nav.Link href="#Contactenos" className={activeLink === 'Contactenos' ? 'active navbar-link' : 'navbar-link'} onClick={() => onUpdateActiveLink('Contactenos')}>Contactenos</Nav.Link>
            </Nav>
            <span className="navbar-text">
              <div className="social-icon">
                <a href="#"><img src={navIcon2} alt="" /></a>
                <a href="#"><img src={navIcon3} alt="" /></a>
              </div>
              <HashLink to='/login#connect'>
                <button className="vvd"><span>Mi cuenta</span></button>
              </HashLink>
            </span>
          </Navbar.Collapse>
        </Container>
      </Navbar>
  )
}
