package Services;

import Enums.ParkingSlotAssignmentStrategyType;
import Enums.VehicleType;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.VehicleRepository;
import SpotAssignmentStrategyFactory.SpotAssignmentStrategyFactory;
import Strategies.ParkingSlotAssignmentStrategy.ParkingSpotAssignmentStrategy;
import Models.Gate;
import Models.ParkingLot;
import Models.Ticket;
import Models.Vehicle;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private VehicleRepository vehicleRepository;
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(VehicleRepository vehicleRepository,
                         GateRepository gateRepository,
                         ParkingLotRepository parkingLotRepository) {
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket issueTicket(int vehicleNum, String vehicleOwnerName, VehicleType vehicleType, int gateNum) {

        //create new ticket obj and set all attributes of ticket
       // ticketnum, entrytime, vehicletype, assignedspot, gate, operator, ownername

        Ticket ticket = new Ticket();

        ticket.setNum("Ticket Id - " + vehicleNum);

        ticket.setEntryTime(new Date());

        //to set vehicle type first check whether vehicle is aldy present in db if yes then get its type and set to ticket
        //else create new vehicle save in db and then set to ticket.

        Optional<Vehicle> savedVehicle = vehicleRepository.getVehicleByNum(vehicleNum);

        if(savedVehicle.isPresent()) {
            ticket.setVehicleType(savedVehicle.get().getVehicleType());//TODO : verify ticket should contain vehicleType or vehicle obj.
        } else {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setVehicleNum(vehicleNum);
            newVehicle.setOwnerName(vehicleOwnerName);
            newVehicle.setVehicleType(vehicleType);
            vehicleRepository.saveVehicle(newVehicle);
            ticket.setVehicleType(vehicleType);
        }

        // get gate by id from gate repository
        Gate gate = gateRepository.getGateById(gateNum).get();

        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        //get assigned spot from spotassignmentstrategyfactory
        //first fetch parkinglot id using gate id and then from parking lot we have strategy type
        //gatId -> parkinglotid -> spotassignmentstrategytype

        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGate(gateNum);
        ParkingSlotAssignmentStrategyType type = parkingLot.getParkingSlotAssignmentStrategyType();

        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpot(type);

        ticket.setAssignedSpot(parkingSpotAssignmentStrategy.getSpot(type));

        ticket.setOwnerName(vehicleOwnerName);

        return ticket;
    }
}
