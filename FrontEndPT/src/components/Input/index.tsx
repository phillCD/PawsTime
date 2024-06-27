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
          className="form-select block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding bg-no-repeat border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
          type={type}
          onChange={onChange}
          value={values}
        />
      </div>
    </div>
  );
};

export default InputComponent;
