import React from "react";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";
import "./SectionTopSlider.css";

import TopSlider from "./CoreComponents/TopSlider";

const SectionTopSlider = (props) => {
  const topSlider = {
    arrows: false,
    dots: true,
    autoplay: true,
    autoplaySpeed: 3000,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
  };

  if (props.items.length === 0) {
    return (
      <div className="w3-center">
        <h2>No Sliders found.</h2>
      </div>
    );
  }

  return (
    <React.Fragment>
      <section
        className="w3-row w3-center w3-margin w3-content w3-hover-opacity"
        style={{ maxWidth: "100%" }}
      >
        <Slider {...topSlider}>
          {props.items.map((topSlider) => (
            <div>
              <TopSlider
                key={topSlider.id}
                id={topSlider.id}
                image={topSlider.image}
              />
            </div>
          ))}
        </Slider>
      </section>
    </React.Fragment>
  );
};

export default SectionTopSlider;
