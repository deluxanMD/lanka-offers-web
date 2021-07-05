import React from "react";
import "./SectionHotDeals.css";

import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";
import MainDeals from "./CoreComponents/MainDeals";

const SectionHotDeals = (props) => {
  const dealslider = {
    arrows: false,
    dots: true,
    autoplay: true,
    autoplaySpeed: 3000,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
  };
  return (
    <React.Fragment>
      <section className="w3-row-padding   w3-margin-bottom">
        <div className="w3-quarter hidden">
          <h6>Popular Categories</h6>
          <div className="vertical-menu w3-left-align">
            <a href="#">
              <img
                className="image"
                src="https://assets.access.myfave.gdn/assets/categories/icons/buffets.png"
              />{" "}
              All You Can Eat
            </a>
            <a href="#">
              <img
                className="image"
                src="https://assets-access.myfave.gdn/assets/categories/icons/massage/spa-massage.png"
              />{" "}
              Relaxing Massages
            </a>
            <a href="#">
              <img
                className="image"
                src="https://assets.access.myfave.gdn/assets/categories/icons/eat/cash-voucher.png"
              />{" "}
              Dining Vouchers
            </a>
            <a href="#">
              <img
                className="image"
                src="https://assets.access.myfave.gdn/assets/categories/icons/beauty/hair.png"
              />{" "}
              Hair Affairs
            </a>
            <a href="#">
              <img
                className="image"
                src="https://assets.access.myfave.gdn/assets/categories/icons/asian.png"
              />{" "}
              Asian Cuisine
            </a>
            <a href="#">
              <img
                className="image"
                src="https://d25koy0wu55hre.cloudfront.net/assets/categories/icons/travel/my/theme-parks.png"
              />{" "}
              Fun for All
            </a>
            <a href="#">
              <img
                className="image"
                src="https://d25koy0wu55hre.cloudfront.net/assets/categories/icons/travel/my/islands.png"
              />{" "}
              Island Gateways image
            </a>
          </div>
        </div>
        <div className="w3-threequarter">
          <h6 className="w3-col s6 m6 l6 w3-left-align">Deals of the Day</h6>
          <h6 className=" w3-right-align view w3-text-blue">View All</h6>
          <div className=" w3-center  w3-hover-opacity">
            <Slider {...dealslider}>
              {props.items.map((product) => (
                <div>
                  <MainDeals
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
        </div>
      </section>
    </React.Fragment>
  );
};

export default SectionHotDeals;
