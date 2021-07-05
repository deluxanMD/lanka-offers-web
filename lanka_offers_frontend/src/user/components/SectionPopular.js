import React, { Component } from "react";
import { Link } from "react-router-dom";
import Slider from "react-slick";
import Product from "./CoreComponents/Product";
import "./SectionPopular.css";

const SectionPopular = (props) => {
  const settings = {
    autoplay: true,
    autoplaySpeed: 2000,
    arrows: false,
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 4,
    slidesToScroll: 1,
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
          slidesToShow: 1,
          slidesToScroll: 1,
        },
      },
    ],
  };

  if (props.items.length === 0) {
    return (
      <div className="w3-center">
        <h2>No Popular Products found.</h2>
      </div>
    );
  }

  return (
    <div>
      <section className="w3-row-padding w3-center w3-margin-bottom">
        <h6 className="w3-col s6 m6 l6 w3-left-align">Popular Offers</h6>
        <Link to="/offers">
          <h6
            className="w3-col s6 m6 l6  w3-right-align view"
            style={{ cursor: "pointer" }}
          >
            View All
          </h6>
        </Link>
        <div className="w3-row-padding w3-center ">
          <Slider {...settings}>
            {props.items.map((product) => (
              <div>
                <Product
                  key={product.id}
                  id={product.id}
                  name={product.name}
                  image={product.image}
                  rating={product.rating}
                  discount={product.discount}
                  pricestrike={product.pricestrike}
                  price={product.price}
                  description={product.description}
                  views={product.views}
                />
              </div>
            ))}
          </Slider>
        </div>
      </section>
    </div>
  );
};

export default SectionPopular;
