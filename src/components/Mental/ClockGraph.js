import { Box } from "@mui/material";
import { arc, create, easeLinear, range, scaleLinear, select } from "d3"
import { useEffect, useRef } from "react";


export default function ClockGraph() {
    
    const graphRef = useRef();
    const radians = Math.PI / 180;
    const sixty = scaleLinear()
        .range([0,360])
        .domain([0,60]);
        
    useEffect(() => {
        const svg = select(graphRef.current)
            .attr("viewBox",[0,0,400,400])
            .style("max-width","500px")
            .attr("id","clock");

        const svgContent = svg
            .append("g")
            .attr("id","clock-face")
            .attr("transform", `translate(${[400/2,400/2]})`);
        
        svgContent
            .selectAll(".second-tick")
            .data(range(0,60))
            .enter()
            .append("line")
            .attr("class","second-tick")
            .attr("x1",0)
            .attr("x2",0)
            .attr("y1",200)
            .attr("y2",190)
            .attr("transform", d => `rotate(${sixty(d)})`)
       
            .selectAll(".second-label")
            .data(range(5,61,5))
            .enter()
            .append("text")
            .attr("class","second-label")
            .attr('text-anchor','middle')
            .attr("x", d => 216 * Math.sin(sixty(d) * radians))
            .attr("y", d => -216 * Math.cos(sixty(d) * radians) + 7)
            .text(d => d);
            
        const arcMain = arc()
            .innerRadius(200)
            .outerRadius(180)
            .startAngle(0)
            .endAngle(Math.PI);

        const arcSub = arc()
            .innerRadius(100)
            .outerRadius(90)
            .startAngle(Math.PI)
            .endAngle(Math.PI*2);

        const currentActivity = svgContent
            .append("path")
            .attr("d", arcMain)
            .attr("fill","lightblue")
            .attr("stroke", "gray")
            .attr("stroke-width", 1)
            .style("opacity","0.4");

        const subAcivity = svgContent
            .append("path")
            .attr("d", arcSub)
            .attr("fill", "pink")
            .attr('stroke', "gray")
            .attr("stroke-width", 1)

            
        
        console.log(svg);

            
    },[]);



    return (
        <>
            <Box>
                <svg ref={graphRef} width={500} height={500}></svg>
            </Box>
        </>
    )
}