import { HTMLInputTypeAttribute } from "react";

interface InputComponentProps {
  label: string;
  type?: HTMLInputTypeAttribute;
}

const InputComponent = ({ label, type = "text" }: InputComponentProps) => {
  return (
    <div>
      <p className="font-medium	">{label}</p>
      <div>
        <input
          className="border border-slate-600 rounded-md placeholder:text-xs p-2"
          type={type}
        />
      </div>
    </div>
  );
};

export default InputComponent;
