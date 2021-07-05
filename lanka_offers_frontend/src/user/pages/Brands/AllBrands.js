import React from "react";
import { useSelector } from "react-redux";

const AllBrands = () => {
  const brand = useSelector((state) => state.brand);
  const { brands, main_category, sub_category } = brand;

  const renderAllBrands = () => {
    return brands.map((_brand) => {
      if (
        main_category[_brand.category.main_category_id - 1].checked &&
        sub_category[_brand.category.sub_category_id - 1].checked
      ) {
        return (
          <div className="w3-col s6 m4 l2 w3-hover-opacity w3-margin-bottom w3-image brands-all">
            <img src={_brand.image} className="brand" />
            <h6 className="brand-average-rating">
              {_brand.rating.average}
              <i className="fa fas fa-star brand-average-star" />
            </h6>
          </div>
        );
      }
    });
  };

  return <div className="brands-all">{renderAllBrands()}</div>;
};

export default AllBrands;
