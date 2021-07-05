import React, { Component } from "react";
import './FooterBottom.css';


 const FooterBottom = () =>{

    return (
      <div>
        <div className="w3-center  w3-padding-64 footer2ndrow  " id="footer2ndrow">
  

  <div className="w3-xlarge w3-section">
    <i className="fa fa-facebook-official w3-hover-opacity social"></i>{" "}
    <i className="fa fa-instagram w3-hover-opacity social"></i>{" "}
    <i className="fa fa-snapchat w3-hover-opacity social"></i>{" "}
    <i className="fa fa-pinterest-p w3-hover-opacity social"></i>{" "}
    <i className="fa fa-twitter w3-hover-opacity social"></i>{" "}
    <i className="fa fa-linkedin w3-hover-opacity social"></i>{" "}
  </div>
  <p>Powered by <a href="https://www.codevita.lk" title="CODEVITA" target="_blank" className="w3-hover-text-green"><b>CODEVITA</b></a></p>
        </div>
      </div>
    );
  
};
export default FooterBottom;