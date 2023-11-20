import { Container, Row, Col } from "react-bootstrap";
import navIcon2 from "../assets/img/nav-icon2.svg";
import navIcon3 from "../assets/img/nav-icon3.svg";

export const Footer = () => {
  return (
    <footer className="footer">
      <Container>
        <div className="top">
          <div className="left-content">
            <h1>El Mundo de las Galletas</h1>
            <p>Escoge tu galleta favorita</p>
          </div>
          <div className="right-content">
            <div className="social-icon">
              <a href="#"><img src={navIcon2} alt="Icon" /></a>
              <a href="#"><img src={navIcon3} alt="Icon" /></a>
            </div>
          </div>
          </div>
        <div className="bottom">
          <div>
            <h4>Atención al Cliente</h4>
            <a href="#">961930841</a>
            <a href="#">926312778</a>
            <a href="#">948471077</a>
            <a href="#">950129419</a>
          </div>
          <div>
            <h4>Sobre Nosotros</h4>
            <a href="#">Zonas de Reparto</a>
            <a href="#">Ventas Corporativas</a>
            <a href="#">Comprobantes electrónicos</a>
          </div>
          <div>
            <h4>Políticas & Términos</h4>
            <a href="#">Términos y Condiciones</a>
            <a href="#">Políticas de Privacidad</a>
            <a href="#">Políticas de Devoluciones</a>
          </div>
        </div>
      </Container>
    </footer>
  )
}
