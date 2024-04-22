import { ReactNode } from "react";

interface IModal {
  children: ReactNode;
  onClickOut: () => void;
}

const Modal = ({ children, onClickOut }: IModal) => {
  return (
    <div className="flex flex-1 w-full h-screen items-center justify-center absolute">
      <div
        className="flex flex-1 w-full h-screen z-10 absolute items-center justify-center"
        style={{ backgroundColor: "black", opacity: 0.3 }}
        onClick={onClickOut}
      />
      <div className="bg-white absolute z-20 rounded-md" style={{ opacity: 1 }}>
        {children}
      </div>
    </div>
  );
};

export default Modal;
