import { NavBar } from "../components/NavBar";
import { Banner } from "../components/Banner";
import {Favorite} from "../components/Favorite";
import { Footer } from "../components/Footer";
import '../styles/Home.css';
import 'bootstrap/dist/css/bootstrap.min.css';
const Home = () => {
    return (
        <div className="Home">
            <NavBar />
            <Banner />
            <Favorite />
            <Footer />
        </div>
    )
}

export default Home;
