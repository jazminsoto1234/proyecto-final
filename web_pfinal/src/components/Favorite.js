import meter1 from "../assets/images/meter1.jpg";
import meter2 from "../assets/images/meter2.jpg";
import meter3 from "../assets/images/meter3.jpg";
import meter4 from "../assets/images/meter4.jpg";
import meter5 from "../assets/images/meter5.jpg";
import Carousel from 'react-multi-carousel';
import 'react-multi-carousel/lib/styles.css';
export const Favorite = () => {
  const responsive = {
    superLargeDesktop: {
      // the naming can be any, depends on you.
      breakpoint: { max: 4000, min: 3000 },
      items: 5
    },
    desktop: {
      breakpoint: { max: 3000, min: 1024 },
      items: 3
    },
    tablet: {
      breakpoint: { max: 1024, min: 464 },
      items: 2
    },
    mobile: {
      breakpoint: { max: 464, min: 0 },
      items: 1
    }
  };

  return (
    <section className="favorite" id="favorites">
        <div className="container">
            <div className="row">
                <div className="col-12">
                    <div className="favorite-bx wow zoomIn">
                        <h2>Lo más comprado</h2>
                        <Carousel responsive={responsive} infinite={true} className="owl-carousel owl-theme favorite-slider">
                            <div className="item">
                                <img src={meter1} alt="Image" />
                                <h5>Galletas híbridas</h5>
                            </div>
                            <div className="item">
                                <img src={meter2} alt="Image" />
                                <h5>Galletas de mantequilla con mermelada</h5>
                            </div>
                            <div className="item">
                                <img src={meter3} alt="Image" />
                                <h5>Galletas de almendra molida color rosa</h5>
                            </div>
                            <div className="item">
                                <img src={meter4} alt="Image" />
                                <h5>Galletas de chocolate rellenas de crema de cacahuate</h5>
                            </div>
                            <div className="item">
                                <img src={meter5} alt="Image" />
                                <h5>Galletas integrales</h5>
                            </div>
                        </Carousel>
                    </div>
                </div>
            </div>
        </div>
    </section>
  )
}