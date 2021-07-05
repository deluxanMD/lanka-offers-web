import React from "react";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";

const AllOffers = () => {
  const offer = useSelector((state) => state.offer);
  const { offers, brands, categories, subCategories } = offer;

  const renderAllOffers = () => {
    return offers.map((_offer) => {
      if (
        categories[_offer.category.main - 1].checked &&
        subCategories[_offer.category.sub - 1].checked
      ) {
        return (
          <Link to={`/offers/${_offer.id}`}>
            <div className="w3-col s6 m4 l4 w3-hover-opacity w3-margin-bottom w3-image brands-all">
              <img src={_offer.image} className="brand" />
              <h6 className="brand-average-rating">
                {_offer.rating.average}
                <i className="fa fas fa-star brand-average-star" />
              </h6>
              <h6 className="offer-name">{_offer.name}</h6>
            </div>
          </Link>
        );
      }
    });
  };

  return <div className="brands-all">{renderAllOffers()}</div>;
};

export default AllOffers;
