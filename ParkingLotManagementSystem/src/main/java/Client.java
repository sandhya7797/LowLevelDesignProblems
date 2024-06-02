import Controllers.TicketController;
import DTOS.IssueTicketRequestDTO;
import DTOS.IssueTicketResponseDTO;
import Enums.*;
import Models.*;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.ParkingSpotRepository;
import Repositories.VehicleRepository;
import Services.TicketService;
import SpotAssignmentStrategyFactory.SpotAssignmentStrategyFactory;
import Strategies.ParkingSlotAssignmentStrategy.RandomSpotAssignmentStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

        Operator operator = new Operator();

        operator.setId(1);
        operator.setCreatedAt(new Date());
        operator.setLastModifiedAt(new Date());
        operator.setOperatorName("Sandhya");
        operator.setEmpId(7);

        Gate gate = new Gate();
        gate.setGateNum(1);
        gate.setGateType(GateType.ENTRY);
        gate.setOperator(operator);
        gate.setGateStatusType(GateStatusType.WORKING);

        gateRepository.save(gate);

        List<Gate> gates = new ArrayList<>();
        gates.add(gate);

        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNum(1);

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setFloor(parkingFloor);
        parkingSpot.setParkingSlotStatusType(ParkingSlotStatusType.EMPTY);
        parkingSpot.setSlotNum(12);

        parkingSpotRepository.save(parkingSpot);

        RandomSpotAssignmentStrategy randomSpotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingSpotRepository);
        SpotAssignmentStrategyFactory spotAssignmentStrategyFactory = new SpotAssignmentStrategyFactory(parkingSpotRepository);

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setGates(gates);
        parkingLot.setStatusType(ParkingLotStatusType.OPEN);
        parkingLot.setFeeCalculationStrategyType(FeeCalculationStrategyType.GENERAL);
        parkingLot.setParkingSlotAssignmentStrategyType(ParkingSlotAssignmentStrategyType.RANDOM);

        parkingLotRepository.save(parkingLot);


        TicketService ticketService = new TicketService(
                vehicleRepository,
                gateRepository,
                parkingLotRepository
                );

        TicketController ticketController = new TicketController(ticketService);


        System.out.println("System is Up ! ");

        IssueTicketRequestDTO request = new IssueTicketRequestDTO(7797,
                "Mahesh Reddy",
                VehicleType.FOURWHEELER,
                1);

        IssueTicketResponseDTO response = ticketController.issueTicket(request);

        System.out.println(response.getResponseStatus());

        System.out.println(response.getTicket().toString());

    }
}
