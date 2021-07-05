import React from "react";
import { useRouteMatch } from "react-router-dom";
import { useSelector } from "react-redux";

import SectionTopSlider from "../../components/SectionTopSlider";
import { TOPSLIDER } from "../../../shared/constants";

import adVerticle from "../../../assets/images/offers/advertisement_verticle.jpg";
import offer1 from "../../../assets/images/offers/offer1.jpg";

const SingleOffer = () => {
  const match = useRouteMatch();
  const { id } = match.params;

  const offer = useSelector((state) => state.offer);
  const { offers } = offer;

  const renderItem = () =>
    offers.map(
      (_offer) =>
        _offer.id === +id && (
          <>
            <div className="w3-col s12 m12 l4 offer-single-image">
              <img src={_offer.image} width={380} />
            </div>
            <div className="w3-col s12 m12 l8">
              <h1 className="offer-single-name">{_offer.name}</h1>
              <h5 className="offer-single-price">LKR 15000</h5>
              <div className="offer-single-colors-container">
                <p className="offer-single-colors">Colors</p>
                <div
                  className="offer-single-color"
                  style={{ backgroundColor: "red" }}
                ></div>
                <div
                  className="offer-single-color"
                  style={{ backgroundColor: "green" }}
                ></div>
                <div
                  className="offer-single-color"
                  style={{ backgroundColor: "blue" }}
                ></div>
              </div>
              <div className="cart-container">
                <button className="decrement">-</button>
                <p>1</p>
                <button className="increment">+</button>
                <button className="cart-btn w3-green">Remove from cart</button>
              </div>
            </div>
          </>
        )
    );

  const mockDescription = () => (
    <p>
      Lorem Ipsum is simply dummy text of the printing and typesetting industry.
      Lorem Ipsum has been the industry's standard dummy text ever since the
      1500s, when an unknown printer took a galley of type and scrambled it to
      make a type specimen book. It has survived not only five centuries, but
      also the leap into electronic typesetting, remaining essentially
      unchanged. It was popularised in the 1960s with the release of Letraset
      sheets containing Lorem Ipsum passages, and more recently with desktop
      publishing software like Aldus PageMaker including versions of Lorem
      Ipsum.
    </p>
  );

  const relatedOffers = () =>
    [...Array(6)].map((index, arr) => (
      <div className="w3-col s2 m2 l2 related-offer">
        <img src={offer1} width={280} />
      </div>
    ));

  const renderAds = () => (
    <div className="verticle-ads">
      <img src={adVerticle} />
    </div>
  );

  return (
    <section
      className="w3-row w3-center w3-margin w3-content"
      style={{ maxWidth: "100%" }}
    >
      <div className="spacer"></div>
      <div className="w3-row" style={{ marginTop: 40 }}>
        <div className="w3-col s2 m2 l2">{renderAds()}</div>
        <div className="w3-col s8 m8 l8 offer-single-description">
          {renderItem()}
          <h2>Description</h2>
          {mockDescription()}
          {mockDescription()}
          {mockDescription()}
        </div>
        <div className="w3-col s2 m2 l2">{renderAds()}</div>
      </div>

      <div className="w3-row">
        <h2>Related Offers</h2>
        {relatedOffers()}
      </div>
    </section>
  );
};

export default SingleOffer;
