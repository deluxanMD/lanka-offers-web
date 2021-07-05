import { combineReducers } from "redux";

import brandReducer from "./brandReducers";
import offerReducer from "./offerReducer";

const rootReducer = combineReducers({
  brand: brandReducer,
  offer: offerReducer,
});

export default rootReducer;
