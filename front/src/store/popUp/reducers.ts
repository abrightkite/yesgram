import { ReactNode } from "react";
import { PopUpType } from "../../typedef/common/common.types";
import { PopUpAction } from "./actions";
import {
  CLEAR_POP_UP,
  UPDATE_IS_SHOWN,
  UPDATE_POP_UP_CHILD,
} from "./modules/actionsTypes";

export type PopUpState = PopUpType;

const initialState = {
  popUp: null,
  isShown: false,
};

const popUpReducer = (
  state: PopUpState = initialState,
  { type, payload }: PopUpAction
): PopUpState => {
  switch (type) {
    case UPDATE_POP_UP_CHILD:
      return { ...state, popUp: payload as ReactNode };
    case UPDATE_IS_SHOWN:
      return { ...state, isShown: payload as boolean };
    case CLEAR_POP_UP:
      return initialState;
    default:
      return state;
  }
};

export default popUpReducer;
