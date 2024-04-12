import "../../index.css";
import "react-calendar/dist/Calendar.css";
import ListCard from "../../components/ListCard";
import { PatientDetail } from "../../components/PatientDetails";
import SimpleButton from "../../components/SimpleButton";
import AddIcon from '../../assets/add.svg';

export default function OwnersPage() {
  return (
    <div className="flex flex-1 h-screen p-8 bg-slate-100 gap-5">
      <PatientDetail
        image="https://img.freepik.com/fotos-gratis/retrato-de-homem-feliz-e-sorridente_23-2149022620.jpg"
        petName="Nome do dono"
        type="(48) 9 9999-9999"
        breed="teste@email.com"
        gender=""
        ownerName="000.000.000-00"
      />
      <div className="w-full gap-9">
        <div className="bg-white w-full flex flex-1 flex-row text-center rounded-md items-center justify-center">
          <div className="bg-white w-full text-center rounded-md p-4">
            <p>Donos</p>
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
                <p>Nome</p>
                <p>Telefone</p>
                <p>Email</p>
              </div>
            </div>
            <ListCard
              id="ID"
              breed="Nome do Dono"
              petName="(48) 9 9999-999"
              ownerName="teste@email.com"
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
