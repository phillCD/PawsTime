import { createContext } from "react";

interface IAuthContext {
  userId: string;
  setUserId: (userId: string) => void;
  clinicId: string;
  setClinicId: (clinicId: string) => void;
}

export const AuthContext = createContext<IAuthContext>(null!);
