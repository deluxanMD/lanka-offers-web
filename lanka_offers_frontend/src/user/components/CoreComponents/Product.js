import React from "react";
import './Product.css';

const Product = (props) => {
  return (
    <div>
      <div className="cardcolumn   w3-hover-opacity">
        <a href="#home">
          <img
            src={props.image}
            className="product"
            style={{ width: "100%" }}
          />
          <div className="top-left">{props.discount}</div>
          <div className="top-left2">
            <i
              className="fa fa-star"
              style={{
                fontSize: "16px",
                color: "rgb(255, 255, 255)",
              }}
            />{" "}
            {props.rating}
          </div>
          <div className="top-left3">
            {props.views}{" "}
            <i
              className="fa fa-eye"
              style={{
                fontSize: "16px",
                color: "rgb(255, 255, 255)",
              }}
            />
          </div>
          <div className="cardcontent">
            <h5>{props.name}</h5>
            <span className="pricestrike">RS:{props.pricestrike}</span>
            <span className="price">RS:{props.price}</span>
            <span className="description">{props.description}</span>

            <button
              className="w3-btn w3-margin-top w3-green  w3-round"
              style={{ width: "40%", fontSize: "20px" }}
            >
              {" "}
              <i className="fa fa-book" style={{ fontSize: "22px" }} />
              &nbsp; Details
            </button>
          </div>
        </a>
      </div>
    </div>
  );
};

export default Product;
