@RestController
class GreetingRestController {
  
	@RequestMapping("/hi/{name}")
	def hi(@PathVariable String name) {
    	[greetings:"Hello "+name+"!"]
	}
}
