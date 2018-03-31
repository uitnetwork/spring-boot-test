import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return Service1 by id=1"

    request {
        url "/service1/1"
        method GET()
    }

    response {
        status 200
        headers {
            contentType applicationJson()
        }

        body(
                id: 1,
                name: "something"
        )
    }
}
