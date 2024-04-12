import "../../index.css";
import "react-calendar/dist/Calendar.css";
import ListCard from "../../components/ListCard";
import { PatientDetail } from "../../components/PatientDetails";
import SimpleButton from "../../components/SimpleButton";
import AddIcon from '../../assets/add.svg';


export default function PatientsPage() {
  return (
    <div className="flex flex-1 h-screen p-8 bg-slate-100 gap-5">
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
            <p>Pacientes</p>
          </div>
          <div className="mr-3">
            <SimpleButton icon={AddIcon}/>
          </div>
        </div>
        <div className="flex flex-1 flex-col bg-white mt-5 rounded-2xl p-6">
          <div className="flex flex-1 flex-col gap-2">
            <div className="flex flex-row w-full p-2 px-10 bg-slate-400 rounded-md items-center">
              <div className="flex flex-row flex-1 justify-between">
                <p>ID</p>
                <p>Raça</p>
                <p>Nome do animal</p>
                <p>Nome do dono</p>
              </div>
            </div>
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
            <ListCard
              id="ID"
              petName="Nome do Animal"
              breed="Raça"
              ownerName="Nome do Dono"
            />
          </div>
        </div>
      </div>
    </div>
  );
}
