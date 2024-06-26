import { HTMLInputTypeAttribute } from "react";

interface InputComponentProps {
  id: string,
  name: string,
  label: string;
  type?: HTMLInputTypeAttribute;
  onChange: any;
  values: string;
}

const InputComponent = ({ label, type = "text", id, name, onChange, values }: InputComponentProps) => {
  return (
    <div>
      <p className="font-medium	">{label}</p>
      <div>
        <input
          id={id}
          name={name}
          className="border border-slate-600 rounded-md placeholder:text-xs p-2"
          type={type}
          onChange={onChange}
          value={values}
        />
      </div>
    </div>
  );
};

export default InputComponent;
