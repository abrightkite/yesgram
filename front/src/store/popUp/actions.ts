import { ReactNode } from "react";
import {
  CLEAR_POP_UP,
  UPDATE_IS_SHOWN,
  UPDATE_POP_UP_CHILD,
} from "./modules/actionsTypes";

export const updatePopUpChildAction = (payload: ReactNode) => ({
  type: UPDATE_POP_UP_CHILD,
  payload,
});

export const updateIsShownAction = (payload: boolean) => ({
  type: UPDATE_IS_SHOWN,
  payload,
});

export const clearPopUpAction = () => ({
  type: CLEAR_POP_UP,
  payload: {},
});

export type PopUpAction =
  | ReturnType<typeof updatePopUpChildAction>
  | ReturnType<typeof updateIsShownAction>
  | ReturnType<typeof clearPopUpAction>;
