let chartCreated = false;

fetch('/dashboard/summary')
    .then(response => response.json())
    .then(data => {

        document.getElementById('devices')
            .innerText = data.totalDevices;

        document.getElementById('telemetry')
            .innerText = data.totalTelemetry;

        document.getElementById('alerts')
            .innerText = data.totalAlerts;
    });

fetch('/telemetry')
    .then(response => response.json())
    .then(data => {

        const telemetryTable =
            document.getElementById(
                'telemetryTable'
            );

        telemetryTable.innerHTML = "";

        data.slice(-5)
            .reverse()
            .forEach(item => {

                telemetryTable.innerHTML += `

                    <tr>

                        <td>${item.machineId}</td>

                        <td>${item.temperature}°C</td>

                        <td>${item.vibration}</td>

                        <td>${item.rpm}</td>

                    </tr>

                `;
            });

        if(!chartCreated){

            chartCreated = true;

            const latest =
                data.slice(-5);

            const labels =
                latest.map(
                    t => t.machineId
                );

            const temps =
                latest.map(
                    t => t.temperature
                );

            const ctx =
                document.getElementById(
                    'tempChart'
                );

            new Chart(ctx, {

                type: 'bar',

                data: {

                    labels: labels,

                    datasets: [{

                        label:
                            'Temperature (°C)',

                        data: temps,

                        backgroundColor:
                            '#3b82f6',

                        borderRadius: 8
                    }]
                },

                options: {

                    responsive: true,

                    plugins: {

                        legend: {

                            labels: {

                                color:
                                    '#ffffff'
                            }
                        }
                    },

                    scales: {

                        x: {

                            ticks: {

                                color:
                                    '#ffffff'
                            },

                            grid: {

                                color:
                                    '#334155'
                            }
                        },

                        y: {

                            ticks: {

                                color:
                                    '#ffffff'
                            },

                            grid: {

                                color:
                                    '#334155'
                            }
                        }
                    }
                }
            });
        }

    });

fetch('/alerts')
    .then(response => response.json())
    .then(data => {

        const alertTable =
            document.getElementById(
                'alertTable'
            );

        alertTable.innerHTML = "";

        data.slice(-5)
            .reverse()
            .forEach(item => {

                let badge =
                    "bg-success";

                if(item.severity === "HIGH")
                    badge = "bg-warning";

                if(item.severity === "CRITICAL")
                    badge = "bg-danger";

                alertTable.innerHTML += `

                    <tr>

                        <td>${item.machineId}</td>

                        <td>

                            <span class="badge ${badge}">
                                ${item.severity}
                            </span>

                        </td>

                        <td>${item.message}</td>

                    </tr>

                `;
            });

    });