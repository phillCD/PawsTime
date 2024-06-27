import { useState } from "react";
import { AuthContext } from "./AuthContext";

export const AuthProvider = ({ children }: { children: JSX.Element }) => {
  const [userId, setUserId] = useState<string>("");
  const [clinicId, setClinicId] = useState<string>("");

  return (
    <AuthContext.Provider value={{ userId, setUserId, clinicId, setClinicId }}>
      {children}
    </AuthContext.Provider>
  );
};
