import React from "react";
import "./MainDeals.css";

const MainDeals = (props) => {
  return (
    <div>
      <div className="w3-container w3-white ">
        <div className="w3-col s12 m6 l8  w3-left   w3-padding-16 maindeal">
          <img
            className="w3-image display-image"
            src={props.image}
            alt="Avatar"
          />
          <div class="deals-left">You Save {props.discount}</div>
          <div class="rating-left">
            <i
              className="fa fa-star"
              style={{
                fontSize: "16px",
                color: "rgb(255, 255, 255)",
              }}
            />{" "}
             {props.views}
          </div>
        </div>
        <div className="w3-col s12 m6 l4  w3-padding">
          <div className="w3-left-align w3-margin-left">
            <h5>{props.name}</h5>
            <span className="prifvcestrike">RS:{props.pricestrike}</span>
            <span className="price">RS:{props.price}</span>
            <h6 className="description">{props.description}</h6>
            <h6 className="description"> {props.discount}</h6>
            <span className="sold">{props.views} Views</span>
            <h6>
              <i
                className="fa fa-play"
                style={{
                  fontSize: "16px",
                  color: "rgb(238, 223, 11)",
                }}
              />{" "}
              &nbsp;Limited Time Offer
            </h6>

            <button
              className="w3-btn  w3-green w3-border  w3-border-yellow w3-padding-large w3-round"
              style={{ width: "100%", fontSize: "20px", marginTop: "100px" }}
            >
              {" "}
              <i className="fa fa-bookmark" style={{ fontSize: "22px" }} />
              &nbsp; View More
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MainDeals;
