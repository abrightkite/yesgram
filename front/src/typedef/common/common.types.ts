export type BasicAPIResponseErrorType = {
  error: string;
  message: string;
};

export type PopUpType = {
  popUp: React.ReactNode;
  isShown: boolean;
};

export type GameRoomType = {
  id: string;
  code: string;
  title: string;
  type: string;
  board_size: number;
  max_participant: number;
  password: string | null;
  created_user_id: string;
};

export type KickedUserType = {
  id: string;
  user_id: string;
  game_room_id: string;
};

export type GameBoardListRequestType = {
  size: number;
  cleared: boolean;
  page: number;
};

export type GameBoardListResponseType = {
  boards: GameBoardForListType[];
};

export type GameBoardForListType = {
  id: string;
  size: number;
  board: string | null;
  cleared: boolean;
};

export type GameBoardDetailRequestType = {
  board_id: string;
};

export type GameboardDetailResponseType = {
  id: string;
  size: number;
  board: string;
};

export type GameBoardDetailRandomRequestType = {
  size: number;
  cleared: boolean;
};

export type GameBoardDetailRandomResponseType = {
  id: string;
  size: number;
  board: string;
};
