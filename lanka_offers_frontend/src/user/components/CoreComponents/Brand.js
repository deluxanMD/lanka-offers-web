import React  from "react";
import './Brand.css';

const Brand = props => {

    return (
      <div className="  w3-hover-opacity  w3-image  brandSlider">
        <div class="w3-tooltip">
          <p class="w3-text">{props.name} </p>
          <img src={props.image} className="brand " />
        </div>
      </div>
    );

};
export default Brand;
