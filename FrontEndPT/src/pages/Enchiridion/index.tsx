import "../../index.css";
import "react-calendar/dist/Calendar.css";
import { PatientDetail } from "../../components/PatientDetails";
import SimpleButton from "../../components/SimpleButton";
import AddIcon from "../../assets/add.svg";
import { useNavigate } from "react-router-dom";

export default function Enchiridion() {
  const navigate = useNavigate();

  return (
    <div className="flex flex-1 h-full p-8 bg-slate-100 gap-5">
      <PatientDetail
        image="https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*"
        petName="Nome do animal"
        type="Tipo"
        breed="Raça"
        gender="Sexo"
        ownerName="Dono: Nome do dono"
      />
      <div className="w-full gap-9">
        <div className="bg-white w-full text-center rounded-md flex flex-1 flex-row items-center justify-center">
          <div className="bg-white w-full text-center rounded-md p-4">
            <p>Prontuário</p>
          </div>
        </div>
        <div className="flex flex-1 flex-row gap-9 pt-6 h-screen">
          <div className="bg-white text-center rounded-md w-full justify-center p-6">
            <div>
              <p>Anamnese</p>
            </div>
            <form className="flex flex-1 flex-col mt-6 gap-6">
              <textarea className="flex flex-1 border min-h-36" />
              <div>
                <SimpleButton label="Salvar" />
              </div>
            </form>
          </div>
          <div className="bg-white w-full  text-center rounded-md justify-center p-6">
            <div>
              <p>Prontuário</p>
            </div>
            <form className="flex flex-1 flex-col mt-6 gap-6">
              <textarea className="flex flex-1 border min-h-36" />
              <div>
                <SimpleButton label="Salvar" />
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
