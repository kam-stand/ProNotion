import { HStack } from "@chakra-ui/react"
import { Button } from "@chakra-ui/react"
export default function Buttons() {
    return (
       <>
         <HStack spacing="24px">
              <Button colorScheme="purple" size="md">
                 Home
              </Button>
              <Button colorScheme="purple" size="md">
                 Pricing
              </Button>
              <Button colorScheme="purple" size="md">
                 Login
              </Button>
            </HStack>
       </>
    )
    }