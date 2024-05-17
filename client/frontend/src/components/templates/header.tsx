import { Flex, Icon } from "@chakra-ui/react";
import Buttons from "./buttons/buttons";

export default function Header() {
  return (
    <Flex dir="row" alignContent={"center"} justifyContent={"space-between"}>
      <Icon />
      <Buttons />
    </Flex>
  );
}
