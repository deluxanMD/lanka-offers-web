import React from "react";
import { Link } from "react-router-dom";
import "./SectionBrand.css";
import Brand from "./CoreComponents/Brand";

import Slider from "react-slick";

const SectionBrand = (props) => {
  var settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 6,
    slidesToScroll: 1,
    autoplaySpeed: 2000,
    arrows: false,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 3,
          infinite: true,
          dots: true,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 2,
          initialSlide: 2,
        },
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1,
        },
      },
    ],
  };

  if (props.items.length === 0) {
    return (
      <div className="w3-center">
        <h2>No Brands found.</h2>
      </div>
    );
  }

  return (
    <React.Fragment>
      <section className="w3-row-padding  w3-margin-bottom">
        <h6 className="w3-col s6 m6 l6 w3-left-align">Brands</h6>
        <Link to="/brands">
          <h6
            className="w3-col s6 m6 l6  w3-right-align view"
            style={{ cursor: "pointer" }}
          >
            View All
          </h6>
        </Link>
        <div className="w3-row-padding w3-center">
          <Slider {...settings}>
            {props.items.map((brand) => (
              <div>
                <Brand
                  key={brand.id}
                  id={brand.id}
                  image={brand.image}
                  name={brand.name}
                />
              </div>
            ))}
          </Slider>
        </div>
      </section>
    </React.Fragment>
  );
};

export default SectionBrand;
