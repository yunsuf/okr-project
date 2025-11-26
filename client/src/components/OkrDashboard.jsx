import React, { useState, useEffect } from 'react';
import { getObjectives, createObjective, deleteObjective, addKeyResult } from '../services/api';
import AiAssistant from './AiAssistant';
import OkrChat from './OkrChat';

const OkrDashboard = () => {
    const [objectives, setObjectives] = useState([]);
    const [newObjective, setNewObjective] = useState({
        title: '',
        description: '',
        status: 'PLANNED',
        scope: 'TEAM',
        purpose: 'COMMITTED'
    });
    const [expandedObj, setExpandedObj] = useState(null);
    const [newKeyResult, setNewKeyResult] = useState({
        title: '',
        weight: 0,
        targetDate: '',
        type: 'PERCENTAGE',
        minValue: 0,
        targetValue: 100,
        maxValue: 100
    });

    const userId = 1; // Hardcoded for demo

    useEffect(() => {
        loadObjectives();
    }, []);

    const loadObjectives = async () => {
        try {
            const response = await getObjectives();
            setObjectives(response.data);
        } catch (error) {
            console.error('Error loading objectives:', error);
        }
    };

    const handleCreateObjective = async () => {
        try {
            await createObjective(userId, newObjective);
            setNewObjective({
                title: '',
                description: '',
                status: 'PLANNED',
                scope: 'TEAM',
                purpose: 'COMMITTED'
            });
            loadObjectives();
        } catch (error) {
            console.error('Error creating objective:', error);
        }
    };

    const handleDeleteObjective = async (id) => {
        try {
            await deleteObjective(id);
            loadObjectives();
        } catch (error) {
            console.error('Error deleting objective:', error);
        }
    };

    const handleAddKeyResult = async (objectiveId) => {
        try {
            await addKeyResult(objectiveId, newKeyResult);
            setNewKeyResult({
                title: '',
                weight: 0,
                targetDate: '',
                type: 'PERCENTAGE',
                minValue: 0,
                targetValue: 100,
                maxValue: 100
            });
            loadObjectives();
        } catch (error) {
            console.error('Error adding key result:', error);
        }
    };

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-3xl font-bold mb-6 text-blue-600">OKR Dashboard (Constitution Aligned)</h1>

            <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
                <div className="lg:col-span-2">
                    {/* Add Objective Form */}
                    <div className="bg-white p-6 rounded-lg shadow-md mb-6 border border-gray-200">
                        <h2 className="text-xl font-semibold mb-4">Add New Objective</h2>
                        <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-4">
                            <input
                                type="text"
                                placeholder="Title"
                                className="w-full p-2 border rounded"
                                value={newObjective.title}
                                onChange={(e) => setNewObjective({ ...newObjective, title: e.target.value })}
                            />
                            <select
                                className="w-full p-2 border rounded"
                                value={newObjective.scope}
                                onChange={(e) => setNewObjective({ ...newObjective, scope: e.target.value })}
                            >
                                <option value="COMPANY">Company</option>
                                <option value="TEAM">Team</option>
                                <option value="INDIVIDUAL">Individual</option>
                            </select>
                            <select
                                className="w-full p-2 border rounded"
                                value={newObjective.purpose}
                                onChange={(e) => setNewObjective({ ...newObjective, purpose: e.target.value })}
                            >
                                <option value="COMMITTED">Committed</option>
                                <option value="ASPIRATIONAL">Aspirational</option>
                                <option value="LEARNING">Learning</option>
                            </select>
                            <input
                                type="text"
                                placeholder="Status (PLANNED)"
                                className="w-full p-2 border rounded"
                                value={newObjective.status}
                                onChange={(e) => setNewObjective({ ...newObjective, status: e.target.value })}
                            />
                        </div>
                        <textarea
                            placeholder="Description"
                            className="w-full p-2 border rounded mb-4"
                            value={newObjective.description}
                            onChange={(e) => setNewObjective({ ...newObjective, description: e.target.value })}
                        />
                        <button
                            onClick={handleCreateObjective}
                            className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 w-full"
                        >
                            Add Objective
                        </button>
                    </div>

                    {/* Objectives List */}
                    <div className="space-y-4">
                        {objectives.map((obj) => (
                            <div key={obj.id} className="bg-white p-4 rounded-lg shadow border-l-4 border-blue-500">
                                <div className="flex justify-between items-start mb-2">
                                    <div>
                                        <div className="flex items-center gap-2">
                                            <h3 className="text-lg font-bold">{obj.title}</h3>
                                            <span className="text-xs bg-blue-100 text-blue-800 px-2 py-1 rounded">{obj.scope}</span>
                                            <span className="text-xs bg-purple-100 text-purple-800 px-2 py-1 rounded">{obj.purpose}</span>
                                        </div>
                                        <p className="text-gray-600 mt-1">{obj.description}</p>
                                    </div>
                                    <div className="flex gap-2">
                                        <button
                                            onClick={() => setExpandedObj(expandedObj === obj.id ? null : obj.id)}
                                            className="text-gray-500 hover:text-gray-700"
                                        >
                                            {expandedObj === obj.id ? 'Hide KRs' : 'Show KRs'}
                                        </button>
                                        <button
                                            onClick={() => handleDeleteObjective(obj.id)}
                                            className="text-red-500 hover:text-red-700"
                                        >
                                            Delete
                                        </button>
                                    </div>
                                </div>

                                {/* Key Results Section */}
                                {expandedObj === obj.id && (
                                    <div className="mt-4 pl-4 border-l-2 border-gray-200">
                                        <h4 className="font-semibold mb-2">Key Results</h4>
                                        <div className="space-y-2 mb-4">
                                            {obj.keyResults && obj.keyResults.map((kr) => (
                                                <div key={kr.id} className="bg-gray-50 p-3 rounded text-sm">
                                                    <div className="flex justify-between">
                                                        <span className="font-medium">{kr.title}</span>
                                                        <span className="text-gray-500">{kr.weight}% Weight</span>
                                                    </div>
                                                    <div className="flex gap-4 mt-1 text-xs text-gray-500">
                                                        <span>Type: {kr.type}</span>
                                                        <span>Target: {kr.targetValue}</span>
                                                        <span>Date: {kr.targetDate}</span>
                                                    </div>
                                                    <div className="w-full bg-gray-200 rounded-full h-2 mt-2">
                                                        <div
                                                            className="bg-green-500 h-2 rounded-full"
                                                            style={{ width: `${kr.progress}%` }}
                                                        ></div>
                                                    </div>
                                                </div>
                                            ))}
                                        </div>

                                        {/* Add KR Form */}
                                        <div className="bg-gray-100 p-3 rounded">
                                            <h5 className="text-sm font-medium mb-2">Add Key Result</h5>
                                            <input
                                                type="text"
                                                placeholder="KR Title"
                                                className="w-full p-2 border rounded mb-2 text-sm"
                                                value={newKeyResult.title}
                                                onChange={(e) => setNewKeyResult({ ...newKeyResult, title: e.target.value })}
                                            />
                                            <div className="grid grid-cols-2 gap-2 mb-2">
                                                <input
                                                    type="number"
                                                    placeholder="Weight %"
                                                    className="p-2 border rounded text-sm"
                                                    value={newKeyResult.weight}
                                                    onChange={(e) => setNewKeyResult({ ...newKeyResult, weight: parseInt(e.target.value) })}
                                                />
                                                <input
                                                    type="date"
                                                    className="p-2 border rounded text-sm"
                                                    value={newKeyResult.targetDate}
                                                    onChange={(e) => setNewKeyResult({ ...newKeyResult, targetDate: e.target.value })}
                                                />
                                            </div>
                                            <div className="grid grid-cols-3 gap-2 mb-2">
                                                <input
                                                    type="number"
                                                    placeholder="Min"
                                                    className="p-2 border rounded text-sm"
                                                    value={newKeyResult.minValue}
                                                    onChange={(e) => setNewKeyResult({ ...newKeyResult, minValue: parseFloat(e.target.value) })}
                                                />
                                                <input
                                                    type="number"
                                                    placeholder="Target"
                                                    className="p-2 border rounded text-sm"
                                                    value={newKeyResult.targetValue}
                                                    onChange={(e) => setNewKeyResult({ ...newKeyResult, targetValue: parseFloat(e.target.value) })}
                                                />
                                                <input
                                                    type="number"
                                                    placeholder="Max"
                                                    className="p-2 border rounded text-sm"
                                                    value={newKeyResult.maxValue}
                                                    onChange={(e) => setNewKeyResult({ ...newKeyResult, maxValue: parseFloat(e.target.value) })}
                                                />
                                            </div>
                                            <button
                                                onClick={() => handleAddKeyResult(obj.id)}
                                                className="bg-gray-600 text-white px-3 py-1 rounded text-sm hover:bg-gray-700 w-full"
                                            >
                                                Add Key Result
                                            </button>
                                        </div>
                                    </div>
                                )}
                            </div>
                        ))}
                    </div>
                </div>

                <div className="space-y-6">
                    <AiAssistant objectives={objectives} onOkrGenerated={loadObjectives} />
                    <OkrChat objectives={objectives} />
                </div>
            </div>
        </div>
    );
};

export default OkrDashboard;
